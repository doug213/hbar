package com.henta.hedera;

import com.hedera.hashgraph.sdk.*;
import com.hedera.hashgraph.sdk.proto.ResponseCodeEnum;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author henta
 */
@RestController
@RequestMapping({"/hedera"})
public class TransactionController {
    public static final Client CLIENT = Client.forMainnet();

    public TransactionController() {
    }

    @PostMapping({"/sendRawTransaction"})
    public ResponseResult sendRawTransaction(String txHex, String nodeId, String nodeAddress) {
        HashMap<String, AccountId> map = new HashMap(1);
        map.put(nodeAddress, AccountId.fromString(nodeId));

        Transaction transaction;
        ResponseResult responseResult = new ResponseResult();

        try {
            transaction = TransferTransaction.fromBytes(Hex.decode(txHex));
            TransactionId transactionId = transaction.getTransactionId();
            TransactionResponse transactionResponse = (TransactionResponse) transaction.execute(CLIENT);
            TransactionReceipt transactionReceipt = transactionResponse.getReceipt(CLIENT);
            String txId = transactionId.accountId.toString() + "-" + transactionId.validStart.getEpochSecond() + "-" + transactionId.validStart.getNano();
            responseResult.setCode(0);
            responseResult.setInfo(txId);
            responseResult.setResponseCodeEnum(ResponseCodeEnum.valueOf(transactionReceipt.status.name()).getNumber());
            return responseResult;
        } catch (Exception e) {
            ResponseResult errorResult = new ResponseResult();
            errorResult.setCode(-1);
            errorResult.setInfo(e.getMessage());
            e.printStackTrace();
            return errorResult;
        }
    }
}
