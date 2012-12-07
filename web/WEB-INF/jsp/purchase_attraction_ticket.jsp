
<form method="POST" id="purchase-attraction-ticket-form">
    <table>
        <tr>
            <td valign="top">
                # Tickets: <input size="4" class="required numeric" type="text" name="num_tickets" id="num-tickets" />
            </td>
            <td valign="top">
                Date: <input size="12" type="text" name="date_available" id="date-available" class="date-picker required"/>
            </td>
            <td valign="top">
                <input type="hidden" name="attractionId" id="attractionId" value="${attraction.getId()}" />
                <input type="button" value="Check Availability" onclick="Attraction.checkTicketAvailability()"/>
            </td>
        </tr>
    </table>    

    <br/><br/>
    <div id="credit-card-info" style="display: none;">
        <div class="message">Tickets are available.</div> <br/>

        <input type="hidden" id="ticket-cost" name="ticket_cost" value="${attraction.getCostperticket()}"/>
        <table width="75%">
            <tr>
                <td valign="top">
                    <strong>Credit Card</strong>
                    <div>
                        <label>Credit Card #: </label>
                        <input class="required" type="text" name="credit_card_num" id="credit-card-num" value="${paymentInfo.getCreditcardnumber()}"/>
                    </div>
                    <div>
                        <label>Amount:</label> <input size="6" readonly="readonly" class="required" type="text" name="credit_card_amount" id="credit-card-amount" value="0"/>
                    </div>
                </td>
                <td valign="top">
                    <strong>Reward Points</strong>
                    <div>
                            <input type="hidden" value="${guest.getRewardpoints()}" name="available_reward_points" id="available-reward-points" />
                            <label>Available Reward Points:</label> ${guest.getRewardpoints()} <br/>
                            <label>Reward Points Used:</label> <input size="6" class="required" type="text" name="reward_points" id="reward-points" value="0" />
                    </div>
                </td>
            </tr>
        </table>

        <br/>
        <div>
            Cost per ticket: $${attraction.getCostperticket()} <br/>
            <label>Total Amount:</label> <input size="6" type="text" name="total_amount" id="total-amount" readonly="readonly" value="" />
            <input type="submit" value="Purchase" />
        </div>
    </div>
</form>

<script type="text/javascript">
    $(function() {
        Attraction.initPurchase();
    });
</script>