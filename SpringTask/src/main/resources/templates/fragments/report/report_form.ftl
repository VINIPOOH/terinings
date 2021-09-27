<#import "/spring.ftl" as spring/>
<div class="panel panel-default">
    <div class="panel-heading">Create report</div>
    <div class="panel-body">
        <form style="margin-bottom: 30px" name="form_name" autocomplete="off" novalidate ng-submit="sendForm(form)">
            <div class="form-group">
                <label id="inputTopicLabel" for="topicInput">Topic</label>
                <input type="text"
                       class="form-control"
                       id="topicInput"
                       placeholder="Topic"
                       required
                       ng-model="form.topic">
            </div>
            <button type="submit" class="btn btn-success" style="margin-top:30px" ng-disabled="form.$invalid">
                Propose report
            </button>
        </form>
    </div>
</div>