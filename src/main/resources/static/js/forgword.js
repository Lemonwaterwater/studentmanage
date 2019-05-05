/**
 *
 * @authors Your Name (you@example.org)
 * @date    2019-04-27 21:02:09
 * @version $Id$
 */
var eyes=document.getElementById('eyes');
var password=document.getElementById('password');
var onclicknum=0;
function changeEyes(){
    onclicknum++;
    if(onclicknum==1){
        eyes.src='img/eyes_open.png';
        password.type="text";
    }else if(onclicknum==2){
        eyes.src='img/eyes_close.png';
        password.type="password";
        onclicknum=0;
    }
}
