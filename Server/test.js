var request = require('request').defaults({proxy:'http://172.31.1.3:8080', agent:false});
var fs = require('fs');
var progress = require('request-progress');
var firebase=require('firebase');

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


updatesRef.on('child_added',function(childsnapshot,prevchildname){
  //Add downloads
  console.log("added");
  var download = childsnapshot.val();
  start(download.url , download.uid , download.name);
}) ;
updatesRef.on('child_removed',function(childsnapshot,prevchildname){
  //Remove downloads
  console.log("removed");
}) ;

function start(url,uid,f_name){
    console.log(url);
    var t_stamp = ( Date.now() / 1000 | 0 ) ;
    progress(request(url), {
    // throttle: 2000,                    // Throttle the progress event to 2000ms, defaults to 1000ms
    // delay: 1000,                       // Only start to emit after 1000ms delay, defaults to 0ms
    // lengthHeader: 'x-transfer-length'  // Length header to use, defaults to content-length
    })
    .on('progress', function (state) {
    // The state is an object that looks like this:
    // {
    //     percent: 0.5,               // Overall percent (between 0 to 1)
    //     speed: 554732,              // The download speed in bytes/sec
    //     size: {
    //         total: 90044871,        // The total payload size in bytes
    //         transferred: 27610959   // The transferred payload size in bytes
    //     },
    //     time: {
    //         elapsed: 36.235,        // The total elapsed seconds since the start (3 decimals)
    //         remaining: 81.403       // The remaining seconds to finish (3 decimals)
    //     }
    // }
    var data = {UDI : uid , ID : t_stamp , stat : state};
    updatesRef.child("ABC").set(data);
    console.log('progress', state);
    })
    .on('error', function (err) {
    // Do something with err
    })
    .on('end', function () {
        var data = {UDI : uid , ID : t_stamp , stat : {
             percent: 100.00,               // Overall percent (between 0 to 1)
             speed: 0,              // The download speed in bytes/sec
             size: {
                 total: 90044871,        // The total payload size in bytes
                 transferred: 27610959   // The transferred payload size in bytes
             },
             time: {
                 elapsed: 0,        // The total elapsed seconds since the start (3 decimals)
                 remaining: 0       // The remaining seconds to finish (3 decimals)
             }
         }};
        updatesRef.child("ABC").set(data);
    // Do something after request finishes
    })
    .pipe(fs.createWriteStream(f_name));
}
