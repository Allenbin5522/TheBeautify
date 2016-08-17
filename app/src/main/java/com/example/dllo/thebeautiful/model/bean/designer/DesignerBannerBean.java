package com.example.dllo.thebeautiful.model.bean.designer;

import java.util.List;

/**
 * Created by dllo on 16/8/17.
 */
public class DesignerBannerBean {

    /**
     * introduce_images : ["http://dstatic.zuimeia.com/common/image/2016/8/12/06d4e8e6-b5ef-444e-9eba-af36f870fbe3_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/8/12/9d1577ce-dac6-4c1b-8996-6dbbb6b51311_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/8/12/0bcc6a26-e41b-4f58-bb75-3e719bd8e389_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/8/12/405dac4a-7aa4-4e22-8793-8fbcd8c4ec86_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/8/12/223c82f5-b26d-4cb8-aedf-b0f7111ed7b1_1000x1000.jpeg"]
     * city : 伦敦
     * concept : 当你的品牌能够被他人预测的时候，你就遇上大麻烦了
     * article_num : 0
     * name : Jonathan Anderson
     * product_num : 3
     * label : J.W.Anderson 创始人，Loewe 创意总监
     * avatar_url : http://dstatic.zuimeia.com/designer/avatar/2016/8/12/1c550e7b-56cf-44a2-af40-7bfe07f0827b.jpg
     * is_followed : 0
     * id : 82
     * description : J.W. Anderson是时尚界最受追捧的年轻设计师之一，2008年他以男装设计师的身份在伦敦展示了其“非季节性”（off-season）的设计，以此开启了自己的职业生涯。
     */

    private DataBean data;
    /**
     * data : {"introduce_images":["http://dstatic.zuimeia.com/common/image/2016/8/12/06d4e8e6-b5ef-444e-9eba-af36f870fbe3_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/8/12/9d1577ce-dac6-4c1b-8996-6dbbb6b51311_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/8/12/0bcc6a26-e41b-4f58-bb75-3e719bd8e389_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/8/12/405dac4a-7aa4-4e22-8793-8fbcd8c4ec86_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/8/12/223c82f5-b26d-4cb8-aedf-b0f7111ed7b1_1000x1000.jpeg"],"city":"伦敦","concept":"当你的品牌能够被他人预测的时候，你就遇上大麻烦了","article_num":0,"name":"Jonathan Anderson","product_num":3,"label":"J.W.Anderson 创始人，Loewe 创意总监","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/8/12/1c550e7b-56cf-44a2-af40-7bfe07f0827b.jpg","is_followed":0,"id":82,"description":"J.W. Anderson是时尚界最受追捧的年轻设计师之一，2008年他以男装设计师的身份在伦敦展示了其\u201c非季节性\u201d（off-season）的设计，以此开启了自己的职业生涯。"}
     * result : 1
     */

    private int result;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public static class DataBean {
        private String city;
        private String concept;
        private int article_num;
        private String name;
        private int product_num;
        private String label;
        private String avatar_url;
        private int is_followed;
        private int id;
        private String description;
        private List<String> introduce_images;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getConcept() {
            return concept;
        }

        public void setConcept(String concept) {
            this.concept = concept;
        }

        public int getArticle_num() {
            return article_num;
        }

        public void setArticle_num(int article_num) {
            this.article_num = article_num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getProduct_num() {
            return product_num;
        }

        public void setProduct_num(int product_num) {
            this.product_num = product_num;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public int getIs_followed() {
            return is_followed;
        }

        public void setIs_followed(int is_followed) {
            this.is_followed = is_followed;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getIntroduce_images() {
            return introduce_images;
        }

        public void setIntroduce_images(List<String> introduce_images) {
            this.introduce_images = introduce_images;
        }
    }
}
