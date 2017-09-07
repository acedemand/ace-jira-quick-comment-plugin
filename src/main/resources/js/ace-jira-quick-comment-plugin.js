function findDescription(key,component) {
    AJS.$.ajax({
        url: "/jira/rest/quickComment/1.0/" + key,
        type: 'get',
        dataType: 'json',
        async: false,
        success: function (data) {
            component.val(data.description);
        }
    });
}
function setIssueKey(name){
        var queryString = "";
        var regexS = "[\\?&]"+name+"=([^&#]*)",
            regex = new RegExp( regexS ),
            results = regex.exec( window.location.search );
        if( results == null ){
            return "";
        } else{
            queryString = decodeURIComponent(results[1].replace(/\+/g, " "));
        }
        AJS.$("#issueKey").val(queryString)

}
