function add(a,b) {
    return a+b;
}

function swap(a,b) {
    c=a;
    a=b;
    b=c;
}

let a=10;
let b=20;

console.log(a,b);

swap(a,b);

console.log();

// 函数指针
let fuc=function test() {
    console.log('test');
}

//函数作用链,从里往外找
let num=10;
function fuc2() {
    let num=20
    function fuc1(){
        console.log(num);
    }
    fuc1()
}

// fuc();

fuc2();