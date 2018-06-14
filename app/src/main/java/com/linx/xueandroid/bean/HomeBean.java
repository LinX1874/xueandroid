package com.linx.xueandroid.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * 作者：LinX
 * 创建时间：2018/6/14 14:36
 */
public class HomeBean extends BaseObservable {


    private DataBean data=new DataBean();
    private int errorCode;
    private String errorMsg;

    @Bindable
    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Bindable
    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Bindable
    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean extends BaseObservable {


        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas = new ArrayList<>();

        @Bindable
        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        @Bindable
        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }
        @Bindable
        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }
        @Bindable
        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }
        @Bindable
        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
        @Bindable
        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        @Bindable
        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {

            this.datas.addAll(datas);
        }

        public static class DatasBean extends BaseObservable {
            /**
             * apkLink :
             * author : zhhr1122
             * chapterId : 294
             * chapterName : 完整项目
             * collect : false
             * courseId : 13
             * desc : 一款采用MVP模式的设计的仿造腾讯漫画的APP
             * envelopePic : http://www.wanandroid.com/blogimgs/a5f7e48d-1c10-4c06-8c70-56f4b6de50c3.jpg
             * fresh : false
             * id : 2986
             * link : http://www.wanandroid.com/blog/show/2149
             * niceDate : 2018-06-03
             * origin :
             * projectLink : https://github.com/zhhr1122/z_comic_new
             * publishTime : 1528004366000
             * superChapterId : 294
             * superChapterName : 开源项目主Tab
             * tags : [{"name":"项目","url":"/project/list/1?cid=294"}]
             * title : 仿造腾讯漫画的APP z_comic_new
             * type : 0
             * userId : -1
             * visible : 1
             * zan : 0
             */

            private String apkLink;
            private String author;
            private int chapterId;
            private String chapterName;
            private boolean collect;
            private int courseId;
            private String desc;
            private String envelopePic;
            private boolean fresh;
            private int id;
            private String link;
            private String niceDate;
            private String origin;
            private String projectLink;
            private long publishTime;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            private List<TagsBean> tags;
            @Bindable
            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }
            @Bindable
            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }
            @Bindable
            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }
            @Bindable
            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }
            @Bindable
            public boolean isCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }
            @Bindable
            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }
            @Bindable
            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
            @Bindable
            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }
            @Bindable
            public boolean isFresh() {
                return fresh;
            }

            public void setFresh(boolean fresh) {
                this.fresh = fresh;
            }
            @Bindable
            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
            @Bindable
            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
            @Bindable
            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }
            @Bindable
            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }
            @Bindable
            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }
            @Bindable
            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }
            @Bindable
            public int getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(int superChapterId) {
                this.superChapterId = superChapterId;
            }
            @Bindable
            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }
            @Bindable
            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
            @Bindable
            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
            @Bindable
            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }
            @Bindable
            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }
            @Bindable
            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public static class TagsBean extends BaseObservable{
                /**
                 * name : 项目
                 * url : /project/list/1?cid=294
                 */

                private String name;
                private String url;
                @Bindable
                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
                @Bindable
                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
