//获取登录状态
function getUserInfo() {
  $.ajax({
    type: "GET",
    url: "/blogSystem/log",
    success: function (body) {
      //判断body是否合法
      if (body.userId && body.userId > 0) {
        //登录成功
        console.log("用户已经成功 用户名:" + body.userName);
      } else {
        //跳转到登录页面
        alert("请登录后访问");
        location.assign("/blogSystem/Blogger/BloggerLog.html");
      }
    },
    error: function () {
      //跳转到登录页面
      location.assign("/blogSystem/Blogger/BloggerLog.html");
    },
  });
}

getUserInfo();

function changeUserMsg(userName) {
    //根据获取到的信息修改用户信息
    
}
