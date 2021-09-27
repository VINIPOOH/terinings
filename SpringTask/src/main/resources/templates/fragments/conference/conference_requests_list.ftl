<#import "/spring.ftl" as spring/>
<div class="panel panel-default">
    <div class="panel-heading"><@spring.message "label.conferences.requests"/></div>
    <div class="panel-body">
        <table class="table table-striped">
            <thead>
            <tr>
                <th><@spring.message "column.id"/></th>
                <th><@spring.message "label.topic"/></th>
                <th><@spring.message "label.date.and.time"/></th>
                <th><@spring.message "label.address"/></th>
                <th><@spring.message "label.actions"/></th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="item in conferences | orderBy: 'id'">
                <td>{{item.id}}</td>
                <td><a ng-href="#!{{item.id}}">{{item.topic}}</a></td>
                <td>{{item.eventDateTime}}</td>
                <td>{{item.eventAddress}}</td>

                <td>
                    <button class="btn btn-success" style="margin-top:5px" ng-click="processRequest(item.id, true)">
                        <@spring.message "button.approve"/>
                    </button>

                    <button class="btn btn-danger" style="margin-top:5px" ng-click="processRequest(item.id, false)">
                        <@spring.message "button.reject"/>
                    </button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>