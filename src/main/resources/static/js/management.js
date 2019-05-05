/**
 *
 * @authors Your Name (you@example.org)
 * @date    2019-05-03 21:57:17
 * @version $Id$
 */
var tb_name=document.getElementById('tb_name').getElementsByTagName('a');
var tb=document.getElementsByClassName('main_right');
for(var i=0;i<tb_name.length;i++){
    tb_name[i].num=i;
    tb_name[i].onclick=function(){
        for(var j=0;j<tb_name.length;j++){
            tb[j].setAttribute('class','main_right');
        }
        tb[this.num].setAttribute('class','main_right show');
    }
}



var touxiang=document.getElementById('this');
function over(){
    document.getElementById("xgtx").onclick=function(){
document.getElementById("tx").style.height="28%"
}
    for(var j=0;j<tb_name.length;j++){
        tb[j].setAttribute('class','main_right');
    }
   touxiang.setAttribute('class','main_right show');
}


var xiugaitouxiang=document.getElementById('hope');
function leave(){
   xiugaitouxiang.setAttribute('style','display:block');
}

