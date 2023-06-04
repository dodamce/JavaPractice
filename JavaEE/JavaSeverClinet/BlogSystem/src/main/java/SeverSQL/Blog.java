package SeverSQL;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

//每个Blog对象对应数据库表的一条信息
public class Blog {
    private int blogId = -1;
    private String title = "";
    private String content = "";
    private int userId = -1;
    private Timestamp postTime;//时间戳类型

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public int getBlogId() {
        return blogId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getUserId() {
        return userId;
    }

    public String getPostTime() {
        //时间戳到格式化时间的转化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(postTime);
    }
}
