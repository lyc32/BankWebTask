<div class="card-body">
    <h3 class="card-title text-center border-bottom  pb-4">Mail Address</h3>
    <p class="card-text">
    <div class="row g-3">
    <p class="card-text pt-2 border-bottom">
    <div class="row">
        <div class="col-sm-12">
            <label class="col-form-label">Address:</label>
        </div>
        <div class="col-sm-12">
            <div class="row pt-2 pt-2">
                <div class="col-sm-2 text-end">
                    <label for='addressLine1' class="col-form-label">Line 1:</label>
                </div>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="addressLine1" id="addressLine1" required>
                </div>
            </div>
        </div>
        <div class="col-sm-12">
            <div class="row pt-2 pt-2">
                <div class="col-sm-2 text-end">
                    <label for='addressLine2' class="col-form-label">Line 2:</label>
                </div>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="addressLine2" id="addressLine2" placeholder="optional">
                </div>
            </div>
        </div>
        <div class="col-sm-12">
            <div class="row pt-2 pt-2">
                <div class="col-sm-2 text-end">
                    <label for="addressCity" class="col-form-label">City:</label>
                </div>
                <div class="col-sm-4">
                    <input type="text" class="form-control" name="addressCity" id="addressCity" required>
                </div>
                <div class="col-sm-2 text-end">
                    <label for="addressState" class="col-form-label">State:</label>
                </div>
                <div class="col-sm-4">
                    <input type="text" class="form-control" name="addressState" id="addressState" required>
                </div>
            </div>
        </div>
        <div class="col-sm-2 pt-2">
            <label for="addressZipCode" class="col-form-label">ZipCode:</label>
        </div>
        <div class="col-sm-5 pt-2">
            <input type="number" class="form-control" name="addressZipCode" id="addressZipCode" required>
        </div>
    </div>
    </p>

    <p class="card-text pt-2 pb-0 border-bottom">
    <div class="row">
        <div class="col-sm-12">
            <label for="password" class="col-form-label">Password:</label>
            <input type="password" class="form-control" name="password" id="password" onChange="onChange()" required>
        </div>
        <div class="col-sm-12">
            <label for="confirm" class="col-form-label">Confirm Password:</label>
            <input type="password" class="form-control" name="confirm" id="confirm" onChange="onChange()" required>
        </div>
    </div>
    </p>

    <p class="card-text pb-2">
        <div class="col-auto border-top mt-4 pt-4 text-end">
            <input type="submit" class="btn btn-primary mb-3 btn-lg py-1 px-5 ms-4" value="save">
        </div>
    </p>
    </div>
    </p>
</div>
