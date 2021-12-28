<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div id="content">
    <div id="breadcrumbs">
        <ul class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/trainee/home">Home</a></li>
            <li>Manage Class</li>
        </ul>
    </div>
    <div id="main-content">
        <div class="right-content">
            <div id="Class-Overview" class="tab-content class-overview">
                <div class="row place-list">
                    <table>
                        <tr>
                            <th>NAME</th>
                            <td>${assignment.asmName}</td>
                        </tr>
                        <tr>
                            <th>BRIEF</th>
                            <td><a href="${assignment.asmBrief}"></a><i class="fas fa-briefcase"> Brief </i></td>
                        </tr>
                        <tr>
                            <th>DUE</th>
                            <td>${assignment.asmDateDue} ${assignment.asmTimeDue}</td>
                        </tr>
                        <tr>
                            <th>SUBMISSION TYPE</th>
                            <td id="submit-type">${assignment.subType}</td>
                        </tr>
                        <tr>
                            <th>SUBMISSION STATUS</th>
                            <td id="submit-status">OKE</td>
                        </tr>
                    </table>
                    <div>
                        <form method="post" action="http://localhost:8080/cms-btec/trainee-api/upload" enctype="multipart/form-data">
                            <input type="file" name="fileSubmit"/>
                            <button type="submit">Submit File</button>
                        </form>

                    </div>
                </div>
                <script type="text/javascript">
                    function uploadFile() {
                        let json = {file: $('#file-upload').val()}
                        $.ajax({
                            type: "POST",
                            url: "http://localhost:8080/cms-btec/trainee-api/upload",
                            data: JSON.stringify(json),
                            contentType: "application/json",
                            success: function (res){
                                console.log(res)
                            },
                            error: function () {
                                alert("fail")
                            }
                        })
                    }
                </script>
                <ul class="pagination" id="pagination"></ul>
            </div>
        </div>
        <div id="sidebar">
            <div id="calendar">
                <div class="calendar-title">
                    <i class="fas fa-calendar-alt"></i><span>Calendar</span>
                </div>
                <div class="wrapper">
                    <div id="calendari"></div>
                </div>
            </div>
            <div class="events">
                <div class="events-title">
                    <i class="fas fa-calendar-check"></i><span>Events</span>
                </div>
                <div>
                    <div class="panel panel-danger">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                <span class="glyphicon glyphicon-calendar"></span>  Calendar
                                Events
                            </h3>
                        </div>
                        <div class="panel-body">
                            <ul class="media-list">
                                <li class="media">
                                    <div class="media-left">
                                        <div class="panel panel-danger text-center date">
                                            <div class="panel-heading month">
                                                <span class="panel-title strong"> Mar </span>
                                            </div>
                                            <div class="panel-body day text-danger">23</div>
                                        </div>
                                    </div>
                                    <div class="media-body">
                                        <h4 class="media-heading">Assignment 1</h4>
                                        <p>Due : Saturday, 23 January 2021, 11:59 PM</p>
                                    </div>
                                </li>
                                <li class="media">
                                    <div class="media-left">
                                        <div class="panel panel-danger text-center date">
                                            <div class="panel-heading month">
                                                <span class="panel-title strong"> Jan </span>
                                            </div>
                                            <div class="panel-body text-danger day">16</div>
                                        </div>
                                    </div>
                                    <div class="media-body">
                                        <h4 class="media-heading">Assignment 1</h4>
                                        <p>Due : Saturday, 23 January 2021, 11:59 PM</p>
                                    </div>
                                </li>
                                <li class="media">
                                    <div class="media-left">
                                        <div class="panel panel-danger text-center date">
                                            <div class="panel-heading month">
                                                <span class="panel-title strong all-caps"> Dec </span>
                                            </div>
                                            <div class="panel-body text-danger day">8</div>
                                        </div>
                                    </div>
                                    <div class="media-body">
                                        <h4 class="media-heading">Assignment 1</h4>
                                        <p>Due : Saturday, 23 January 2021, 11:59 PM</p>
                                    </div>
                                </li>
                            </ul>
                            <a href="#" class="btn btn-default btn-block">More Events »</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
