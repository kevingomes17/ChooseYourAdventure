<form id="login-form" method="POST" action="j_security_check" >
    <table>
        <tbody>
            <tr>
                <td>Username</td>
                <td><input type="text" class="required" name="j_username" id="username" maxlength="30"></input></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" class="required" name="j_password" id="password" maxlength="30"></input></td>
            </tr>
            <tr>
                <td><input type="submit" name="" value="Login"></input></td>
                <td></td>
            </tr>
        </tbody>            
    </table>
    <input type="hidden" name="j_url" value="channel.jsp"></input>    
</form>

<script type="text/javascript">
    $(function() {
       User.validateLogin(); 
    });
</script>