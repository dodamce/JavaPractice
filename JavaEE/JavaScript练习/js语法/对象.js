//通过{}的方式创建对象

// 对象

let stu = {
    //属性
    name: '小米',
    id: '0001',
    grade: 96.5,

    //方法
    method: function () {
        console.log('考试');
    },

    sleep: function () {
        console.log('睡觉');
    }
}

stu.sleep()

stu.method()

console.log(stu.name)