var request = require('request');
var fs = require('fs');
var progress = require('request-progress');
var firebase=require('firebase');

var requests = {};
var config = {
    apiKey: "AIzaSyB194flT_96KlJGusRCWSPKfjHm0Ncf4Gw",
    authDomain: "remotus-91905.firebaseapp.com",
    databaseURL: "https://remotus-91905.firebaseio.com",
    storageBucket: "remotus-91905.appspot.com",
    messagingSenderId: "772482209313"
};

firebase.initializeApp(config);
var database = firebase.database();
var updatesRef = database.ref("downloads");


updatesRef.on('child_added',function(childsnapshot){
  //Add downloads
  console.log("added");
  var key = childsnapshot.key;
  var download = childsnapshot.val();
  console.log(download);
  if(download.status === "placed"){
      request[key] = start(download.url , download.uid , download.name , key);
  }
}) ;

updatesRef.on('child_changed',function(childsnapshot){
  //Add downloads
  console.log("added");
  var key = childsnapshot.key;
  var download = childsnapshot.val();
  console.log(download);
  if(download.status === "readded"){
      request[key] = start(download.url , download.uid , download.name , key);
  }
}) ;


updatesRef.on('child_removed',function(childsnapshot){
  //Remove downloads
  var key = childsnapshot.key;
  console.log(childsnapshot);
  request[key].end();
  delete requests[key];
  console.log("removed");
}) ;

function start(url,uid,f_name,key){
    console.log(url);
    var req = request(url);
    progress(req, {

    })
    .on('progress', function (state) {
    updatesRef.child(key).child("stat").set(state);
    updatesRef.child(key).child("status").set("progress");
    console.log('progress', state);
    })
    .on('error', function (err) {
    // Do something with err
    updatesRef.child(key).child("status").set("error");
    })
    .on('end', function () {
        updatesRef.child(key).child("status").set("end");
        var data = {
             percent: 1,               // Overall percent (between 0 to 1)
             speed: 0,              // The download speed in bytes/sec
             size: {
                 total: getFilesizeInBytes(f_name),        // The total payload size in bytes
                 transferred: getFilesizeInBytes(f_name)   // The transferred payload size in bytes
             },
             time: {
                 elapsed: 0,        // The total elapsed seconds since the start (3 decimals)
                 remaining: 0       // The remaining seconds to finish (3 decimals)
             }
         };
        updatesRef.child(key).child("stat").set(data);
    // Do something after request finishes
    })
    .pipe(fs.createWriteStream("downloads/"+ f_name));
    return req;
}

function getFilesizeInBytes(filename) {
    const stats = fs.statSync("downloads/"+filename)
    const fileSizeInBytes = stats.size
    return fileSizeInBytes
}
