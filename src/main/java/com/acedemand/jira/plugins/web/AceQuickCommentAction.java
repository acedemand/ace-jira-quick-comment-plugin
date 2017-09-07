package com.acedemand.jira.plugins.web;

import com.acedemand.api.QuickComment;
import com.acedemand.service.AceCommentService;
import com.acedemand.service.QuickCommentService;
import com.atlassian.jira.web.action.JiraWebActionSupport;

import java.util.Collection;

/**
 * Created by Pamir on 3/30/2017.
 */
public class AceQuickCommentAction extends JiraWebActionSupport {

    private QuickCommentService quickCommentService;
    private AceCommentService aceCommentService;
    private String quickcomment;
    private String issueKey;

    public String getQuickcomment() {
        return quickcomment;
    }

    public void setQuickcomment(String quickcomment) {
        this.quickcomment = quickcomment;
    }

    public String getIssueKey() {
        return issueKey;
    }

    public void setIssueKey(String issueKey) {
        this.issueKey = issueKey;
    }

    private Collection<QuickComment> quickComments;

    public Collection<QuickComment> getQuickComments() {
        return quickComments;
    }

    public AceQuickCommentAction() {
        super();
        this.quickCommentService = new QuickCommentService();
        this.aceCommentService = new AceCommentService();
        quickComments = this.quickCommentService.findAll();
    }

    @Override
    public String doDefault() {
        System.out.println("this.getHttpRequest().getMethod() = " + this.getHttpRequest().getMethod());
        return "success";
    }

    public String doComment() {
        System.out.println("this.getHttpRequest().getMethod() = " + this.getHttpRequest().getMethod());
        this.aceCommentService.save(this.issueKey,this.quickcomment,this.getLoggedInApplicationUser());
        return forceRedirect("/jira/browse/"+this.issueKey);
    }
}
