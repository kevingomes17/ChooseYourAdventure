<form id="new-comment-form" method="POST" action="${BasePath}/discussion/new_comment.htm" >
    <table>
        <tbody>
            <tr>
                <td><input type="hidden" name="t_title" value="" id="title" maxlength="50"></input></td>
            </tr>
            <tr>
                <td>Comment</td>
                <td><textarea class="required" name="t_description" id="description" maxlength="50"></textarea></td>
            </tr>
            <!--
            <tr>
                <td><input type="submit"  value="Submit"></input></td>
                <td></td>
            </tr>
            -->
        </tbody>            
    </table>
    <input type="hidden" name="threadId" value=${threadId}></input>    
</form>