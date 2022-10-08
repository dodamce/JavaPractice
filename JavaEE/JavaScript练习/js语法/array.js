//js中的数组

let arr = new Array();

let arr2 = [1, 2, 3, 4];

let arr3 = [1, 'hello', 3.4, null, undefined, true]

for(let i=0;i<arr3.length;i++){
    console.log(arr3[i])
}

console.log(arr3)

// 数组下标越界时，打印结果是undefined
console.log(arr3[100])
console.log(arr3[-1])

arr3[100]=100
console.log(arr3)

//这里的-1代表的是属性，类似键值对
arr3[-1]=10
console.log(arr3)

for(let i=0;i<5;i++){
    arr3.push(i)
}

console.log(arr3)

//删除/替换数组元素
for(let i=0;i<15;i++){
    arr3.splice(2,3,12,'234')
}
console.log(arr3)

