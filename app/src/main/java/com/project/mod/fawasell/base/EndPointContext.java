package com.project.mod.fawasell.base;

public class EndPointContext {

    public static final String BASE_URI = "http://stg.api.fawasell.com/v1/";
    public static final String APP_ID = "14378174";
    public static final String APP_SECRET = "cFJiGxZVTGf3rPNMK1o08WQWWpnr8M9RmZOyGxcM";

    public static class Category{
        public static final String SEGMENT = "categories";

        public static class Methods{

            public static class GetCategories{

                public static class Parameters{
                    public static final String APP_ID = "app_id";
                    public static final String APP_SECRET = "app_secret";
                    public static final String SIGNATURE = "signature";
                }
            }
        }

        public static class Response{
            public static final String ID = "id";
            public static final String NAME = "name";
            public static final String IMAGE = "image";
            public static final String DESCRIPTION = "description";
        }
    }

    public static class Post{
        public static final String SEGMENT = "posts";

        public static class Methods{

            public static class GetPosts{

                public static class Parameters{
                    public static final String APP_ID = "app_id";
                    public static final String APP_SECRET = "app_secret";
                    public static final String SIGNATURE = "signature";
                    public static final String CATEGORY = "category";
                    public static final String PAGE = "page";
                    public static final String LIMIT = "limit";

                }
            }
        }

        public static class Response{
            public static final String ID = "id_post";
            public static final String USER_NAME = "username";
            public static final String NAME = "name";
            public static final String CAPTION = "caption";
            public static final String TYPE = "type";
            public static final String CATEGORY_ID = "category_id";
            public static final String TAG = "tag";
            public static final String URL = "url";
            public static final String MEDIA = "media";
            public static final String VIEW_COUNT = "view_count";
            public static final String LIKE_COUNT = "like_count";
            public static final String DISLIKE_COUNT = "dislike_count";
            public static final String COMMENT_COUNT = "comment_count";
            public static final String RANKING_SCORE = "ranking_score";
            public static final String CREATED_AT = "created_at";
        }
    }

    public static class Media{

        public static class Response{
            public static final String TYPE = "type";
            public static final String URL = "url";
            public static final String TITLE = "title";
        }
    }
}
