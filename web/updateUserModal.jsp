<button type="button" class="btn btn-primary me-3" data-bs-toggle="modal" data-bs-target="#updateModal">
    Change Date
</button>


<div class="modal fade" id="updateModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <form action="/updateUser" method="post">
        <input type="text" value="<%=currentUser.getId()%>" hidden name="user_id">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Change date</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3 row">
                        <label class="col-sm-2 col-form-label">Password</label>
                        <div class="col-10">
                            <input type="text" class="form-control" name="full_name"
                                   value="<%=currentUser.getFullName()%>" required>
                        </div>
                    </div>
                    <div class="my-3 row">
                        <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
                        <div class="col-10">
                            <input type="email" class="form-control" id="staticEmail" name="email"
                                   value="<%=currentUser.getEmail()%>" readonly>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label class="col-sm-2 col-form-label">Password</label>
                        <div class="col-10">
                            <input type="text" class="form-control" name="password"
                                   value="<%=currentUser.getPassword()%>" required>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Back</button>
                    <button type="submit" class="btn btn-success">Save Change</button>
                </div>
            </div>
        </div>
    </form>
</div>