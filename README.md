# Remotus
Remote Download Assistant

Remotus is a remote download assistant. It help you download a file on media server running at your home and manage it 
using the Android App remotely.
The download will use the Internet Connection of your home saving Cellular Data Limits since generally they are metered .

On reaching home, you can find the file on your media server or NAS (Network Assisted Storage) as per the configuration.

The project has 2 components:

* **Android App**: User can view his active downloads, adjust priority and resume/pause/stop a download.
* **Remotus Assistant on Pi**: Remote Assistant is a node.js app running on your media server (simple Raspberry Pi) in our implementation. 
It interface with Android App to get new download information and update status of existing downloads. 

The Android App and Remotus Assistant need not be on the same network. They both just need to be connected to internet.


