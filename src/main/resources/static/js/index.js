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

var eyes2=document.getElementById('confirm_eyes');
var confirm_password=document.getElementById('confirm_password');
var onclicknum2=0;
function changeconfirm(){
    onclicknum2++;
    if(onclicknum2==1){
        eyes2.src='img/eyes_open.png';
        confirm_password.type="text";
    }else if(onclicknum2==2){
        eyes2.src='img/eyes_close.png';
        confirm_password.type="password";
        onclicknum2=0;
    }
}

var getVerification=document.getElementById('getVerification');
var Time=60;
var timer;
var mailbox;

function getCode(){
    getVerification.onclick=null;
    getVerification.style.cursor='default';
    timer=setInterval("getTime()", 1000);

}
function getTime(){
    if(Time>0){
        Time--;
        getVerification.value=Time+"秒后重试";
    }else{
        getVerification.onclick=function(){
            getCode();
        }
        getVerification.style.cursor='pointer';
        getVerification.value='获取邮箱验证码';
        clearTimeout(timer);
        Time=3;
    }
}