<div class="card-body">
    <h3 class="card-title text-center p-4">Request Update Your Mail Address</h3>
    <div class="row g-3">
        <form action="UserOperation" method="post">
            <input type="hidden" name="operation" value="requestNewAddress">
            <div class="row pt-4 pb-4 border-top border-bottom">
                <div class="col-sm-12">
                    <label class="col-form-label"><h4>Address:</h4></label>
                </div>
                <div class="col-sm-12">
                    <div class="row pt-2 pb-2">
                        <div class="col-sm-2 text-end">
                            <label for='addressLine1' class="col-form-label">Line 1:</label>
                        </div>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="addressLine1" id="addressLine1" required>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="row pt-2 pb-2">
                        <div class="col-sm-2 text-end">
                            <label for='addressLine2' class="col-form-label">Line 2:</label>
                        </div>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="addressLine2" id="addressLine2" placeholder="optional">
                        </div>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="row pt-2 pb-2">
                        <div class="col-sm-2 text-end">
                            <label for="addressCity" class="col-form-label">City:</label>
                        </div>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" name="addressCity" id="addressCity" required>
                        </div>
                        <div class="col-sm-1 text-end">
                            <label for="addressState" class="col-form-label">State:</label>
                        </div>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" name="addressState" id="addressState" required>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="row pt-2 pb-2">
                        <div class="col-sm-2 text-end">
                            <label for="addressZipCode" class="col-form-label">ZipCode:</label>
                        </div>
                        <div class="col-sm-4">
                            <input type="number" class="form-control" name="addressZipCode" id="addressZipCode" required>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row pt-4">
                <div class="col-sm-11 text-end">
                    <input type="submit" class="btn btn-primary mb-3 btn-lg py-1 px-5 ms-4" value="Send Request">
                </div>
            </div>
        </form>
    </div>
</div>
