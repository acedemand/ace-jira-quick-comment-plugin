package com.acedemand.jira.plugins.condition;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.plugin.webfragment.conditions.AbstractWebCondition;
import com.atlassian.jira.plugin.webfragment.model.JiraHelper;
import com.atlassian.jira.user.ApplicationUser;

/**
 * Created by Pamir on 3/31/2017.
 */
public class JiraOperationCondition extends AbstractWebCondition {

    public JiraOperationCondition() {
    }


    public boolean shouldDisplay(ApplicationUser user, JiraHelper jiraHelper) {
        //return ComponentAccessor.getGroupManager().isUserInGroup(user.getUsername(), "Jira-Operation");
        return true;
    }

}
