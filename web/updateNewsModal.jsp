<button type="button" class="btn btn-primary me-3" data-bs-toggle="modal" data-bs-target="#updateModal">
    Change News
</button>


<div class="modal fade" id="updateModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <form action="/updateNew" method="post">
        <input type="text" value="<%=oneNew.getId()%>" hidden name="news_id">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Change News</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="title" class="form-label">Title</label>
                        <input type="text" class="form-control" id="title" name="title"
                               value="<%=oneNew.getTitle()%>" required>
                    </div>
                    <div class="mb-3">
                        <label for="category" class="form-label">Category</label>
                        <select class="form-select" id="category" name="category">
                            <%
                                for (int i = 0; i < categories.size(); i++) {
                            %>
                            <option value="<%=i+1%>" <%=oneNew.getCategory_id() == i + 1 ? "selected" : ""%>>
                                <%=categories.get(i).getName()%>
                            </option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="content" class="form-label">Content</label>
                        <textarea class="form-control" id="content" rows="8" name="content"
                                  required><%=oneNew.getContent()%></textarea>
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