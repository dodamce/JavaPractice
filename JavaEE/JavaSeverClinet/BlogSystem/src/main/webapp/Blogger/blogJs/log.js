//获取登录状态
function getUserInfo(pageName) {
  $.ajax({
    type: "GET",
    url: "/blogSystem/log",
    success: function (body) {
      //判断body是否合法
      if (body.userId && body.userId > 0) {
        //登录成功
        console.log("用户已经成功 用户名:" + body.userName);
        //将用户名设置到对应位置
        if (pageName == "BloggerList.html") {
          changeUserMsg(body.userName);
        }
        //博客详情页显示写博客的人的信息
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

function changeUserMsg(userName) {
  //根据获取到的信息修改用户信息
  let user = document.querySelector(".card>h3");
  user.innerHTML = userName;
}
