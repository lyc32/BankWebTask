<div class="card-body">
    <h3 class="card-title text-center p-4">Update Your Password</h3>
    <div class="row g-3">
        <form action="UserOperation" method="post">
            <input type="hidden" name="operation" value="updatePassword">
            <div class="row pt-4 pb-4 border-top border-bottom">
                <div class="col-sm-12">
                    <div class="row pb-4">
                        <div class="col-sm-4 text-end">
                            <label class="col-form-label">Current Password:</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" name="oldPassword" id="oldPassword" required>
                        </div>
                    </div>
                    <div class="row pb-4">
                        <div class="col-sm-4 text-end">
                            <label class="col-form-label">New Password:</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" name="password" id="password" onChange="onChange()"  required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4 text-end">
                            <label class="col-form-label">Confirm Password:</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" name="confirm" id="confirm" onChange="onChange()"  required>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row pt-4">
                <div class="col-sm-11 text-end">
                    <input type="submit" class="btn btn-primary mb-3 btn-lg py-1 px-5 ms-4" value="Update Password">
                </div>
            </div>
        </form>
    </div>
</div>


