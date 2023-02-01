let date = new Date();
let time = date.toLocaleTimeString([], {timeStyle: 'short'});
document.getElementById("time").innerText = time;


// -----chạy thời gian thực----
function localTime() {
    let date = new Date();
    let time = date.toLocaleTimeString([], {timeStyle: 'short'});
    document.getElementById("time").innerText = time;
}

setInterval(localTime, 1000);