<button class="btn btn-outline-danger " type="button"
        data-bs-toggle="modal" aria-haspopup="true" data-bs-target="#<%= (char)('a'+comment.getId())%>deleteComment" aria-expanded="false">
    <i class="bi bi-trash"></i>
</button>


<div class="modal fade" id="<%=(char) ('a'+comment.getId())%>deleteComment" tabindex="-1" aria-labelledby="exampleModalLabel" >
    <form action="/deleteComment" method="post">
        <input type="hidden" value="<%=comment.getId()%>"  name="comment_id">
        <input type="hidden" value="<%=oneNew.getId()%>"  name="news_id">
    <div class="modal-dialog modal-dialog-centered" >
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Delete current comment?</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
    </form>
</div>