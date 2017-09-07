package com.acedemand.service;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.comments.CommentManager;
import com.atlassian.jira.user.ApplicationUser;

/**
 * Created by Pamir on 3/30/2017.
 */
public class AceCommentService {

    public void save(String issueKey, String comment, ApplicationUser applicationUser){
        CommentManager commentManager = ComponentAccessor.getCommentManager();
        commentManager.create(ComponentAccessor.getIssueManager().getIssueObject(issueKey),applicationUser,comment,false);
    }
}
