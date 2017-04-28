package cn.vacuumflask.gankapp.entity.response;

/**
 * Created by Administrator on 2017/4/27 0027.
 * 推荐Fragment响应类
 */

public class RecommendResponse {
    private String imageUrl;
    private String des;

    public RecommendResponse(String imageUrl, String des) {
        this.imageUrl = imageUrl;
        this.des = des;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "RecommendResponse{" +
                "imageUrl='" + imageUrl + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
