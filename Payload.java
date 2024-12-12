package Module5.Part5;

import java.io.Serializable;

public class Payload implements Serializable {
    private PayloadType payloadType;
    private long clientId;
    private String message;
    private String formattedText; // For bold/italic/underline/color
    private int diceRollResult; // For /roll command
    private String coinFlipResult; // For /flip command

    public PayloadType getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(PayloadType payloadType) {
        this.payloadType = payloadType;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFormattedText() {
        return formattedText;
    }

    public void setFormattedText(String formattedText) {
        this.formattedText = formattedText;
    }

    public int getDiceRollResult() {
        return diceRollResult;
    }

    public void setDiceRollResult(int diceRollResult) {
        this.diceRollResult = diceRollResult;
    }

    public String getCoinFlipResult() {
        return coinFlipResult;
    }

    public void setCoinFlipResult(String coinFlipResult) {
        this.coinFlipResult = coinFlipResult;
    }

    @Override
    public String toString() {
        return String.format(
            "Payload[%s] Client Id [%s] Message: [%s], Formatted Text: [%s], Dice Roll: [%d], Coin Flip: [%s]",
            getPayloadType(), getClientId(), getMessage(), getFormattedText(), getDiceRollResult(), getCoinFlipResult()
        );
    }
}
