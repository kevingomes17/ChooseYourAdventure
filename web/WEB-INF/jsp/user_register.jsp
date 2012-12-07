<form method="POST" id="user-register-form">
    <table>
        <tr>
            <td>Email</td>
            <td><input type="text" name="username" id="username" class="required email"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" id="password"  class="required"/></td>
        </tr>
        <tr>
            <td>Confirm Password</td>
            <td><input type="password" name="confirmPassword" id="confirm-password"  class="required"/></td>
        </tr>
        <tr>
            <td>Display Name</td>
            <td><input type="text" name="displayName" id="displayname"  class="required"/></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" id="address"  class="required" /></td>
        </tr>
        <tr>
            <td>City</td>
            <td><input type="text" name="city" id="city"  class="required"/></td>
        </tr><tr>
            <td>Zipcode</td>
            <td><input type="text" name="zipcode" id="zipcode"  class="required"/></td>
        </tr>
    </table>
    
    <h4>Credit Card Info</h4>
    <table>
        <tr>
            <td>Card Number</td>
            <td><input type="text" name="cardNumber" id="card-number" class="required" /></td>
        </tr>
        <tr>
            <td>Expiry</td>
            <td><input type="text" name="expiry" id="expiry" class="date-picker required" /></td>
        </tr>
        <tr>
            <td>CVV Code</td>
            <td><input type="text" name="code" id="code" class="required"/></td>
        </tr>
    </table>
    <input type="submit" value="Register" />
</form>

<script type="text/javascript">
    $(function() {
        User.initRegister();
    });
</script>