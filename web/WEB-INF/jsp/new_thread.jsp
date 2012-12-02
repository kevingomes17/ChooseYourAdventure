<form id="new-thread-form" method="POST" action="" >
    <table>
        <tbody>
            <tr>
                <td>Title</td>
                <td><input type="text" class="required" name="t_title" id="title" maxlength="50"></input></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><textarea class="required" name="t_description" id="description" maxlength="50"></textarea></td>
            </tr>
            <tr>
                <td><input type="submit"  value="Submit"></input></td>
                <td></td>
            </tr>
        </tbody>            
    </table>
    <input type="hidden" name="topicId" value=${topicId}></input>    
</form>