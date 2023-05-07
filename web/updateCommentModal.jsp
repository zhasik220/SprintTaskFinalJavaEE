<button class="btn btn-outline-primary " type="button"
        data-bs-toggle="modal" aria-haspopup="true" data-bs-target="#<%=(char) ('a'+comment.getId())%>updateComment"
        aria-expanded="false">
    <i class="bi bi-pencil"></i>
</button>

<div class="modal fade" id="<%=(char) ('a'+comment.getId())%>updateComment" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <form action="/updateComment" method="post">
        <input type="hidden" value="<%=comment.getId()%>" name="comment_id">
        <input type="hidden" value="<%=oneNew.getId()%>" name="news_id">
        <div class="modal-dialog modal-lg modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Change News</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body text-start">

                    <input type="hidden" name="comment_id" value="<%=comment.getId()%>">
                    <input type="hidden" value="<%=oneNew.getId()%>" name="news_id">
                    <div class="form-group">
                        <label for="comment-content">Comment:</label>
                        <textarea class="form-control" id="comment-content" name="commentText"
                                  placeholder="Write Comment"
                                  rows="3" required><%=comment.getCommentText()%></textarea>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Back</button>
                    <button type="submit" class="btn btn-success">Edit Comment</button>
                </div>
            </div>
        </div>
    </form>
</div>