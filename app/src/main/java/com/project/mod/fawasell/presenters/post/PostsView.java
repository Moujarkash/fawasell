package com.project.mod.fawasell.presenters.post;

import com.project.mod.fawasell.models.post.PostList;
import com.project.mod.fawasell.presenters.base.View;

public interface PostsView extends View {

    int getCategoryId();
    void updateOnFetchPosts(PostList postList);
}
