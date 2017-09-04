<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html lang="en-US" dir="ltr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>addel Example</title>
    
</head>
<body>

<div class="container" style="max-width: 1000px">

    <div class="row">
        <div class="col-sm-5">

            <form class="addel"
                  data-addel-hide="true"
                  data-addel-add="3"
                  data-addel-animation-duration="1000">

                <h2>
                    Organizations
                    <small>
                        data-attributes
                    </small>
                </h2>

                <div class="form-group" data-addel-target>
                    <label for="contact" class="control-label">
                        Organization
                    </label>
                    <div class="input-group">
                        <input type="text" id="contact" name="contacts[]" class="form-control">
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-danger" data-addel-delete>
                                <i class="fa fa-remove"></i>
                            </button>
                        </span>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-4">
                        <button type="button" class="btn btn-success btn-block" data-addel-add="1">
                            <i class="fa fa-plus"></i>
                        </button>
                    </div>
                    <div class="form-group col-sm-4">
                        <button type="button" class="btn btn-success btn-block" data-addel-add="2">
                            <i class="fa fa-plus"></i> 2
                        </button>
                    </div>
                    <div class="form-group col-sm-4">
                        <button type="button" class="btn btn-success btn-block" data-addel-add>
                            <i class="fa fa-plus"></i> 3
                        </button>
                    </div>
                </div>

            </form>

        </div>

        <div class="col-sm-5 col-sm-offset-2">

            <form class="addel">

                <h2>
                    People
                    <small>
                        Traditional options
                    </small>
                </h2>

                <div class="form-group addel-target">
                    <label for="person" class="control-label">
                        Person
                    </label>
                    <div class="input-group">
                        <input type="text" id="person" name="contacts[]" class="form-control">
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-danger addel-delete">
                                <i class="fa fa-remove">

                                </i>
                            </button>
                        </span>
                    </div>
                </div>

                <div class="form-group">
                    <button type="button" class="btn btn-success btn-block addel-add">
                        <i class="fa fa-plus"></i>
                    </button>
                </div>

            </form>

        </div>

    </div>

</div>

 
<script src="source/js/jquery-3.2.1.min.js"></script>
<script src="source/js/addel.jquery.js"></script>

<script>
    $(document).ready(function () {
        $('.addel').addel({
            events: {
                added: function (event) {
                    console.log('Added ' + event.added.length);
                }
            }
        }).on('addel:delete', function (event) {
            if (!window.confirm('Are you absolutely positive you would like to delete: ' + '"' + event.target.find(':input').val() + '"?')) {
                console.log('Deletion prevented!');
                event.preventDefault();
            }
        });
    });
</script>

</body>
</html>
