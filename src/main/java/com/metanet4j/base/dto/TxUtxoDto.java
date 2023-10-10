package com.metanet4j.base.dto;

import com.google.common.base.Objects;
import com.metanet4j.base.type.ScriptType;
import lombok.Data;

import java.util.Set;


@Data
public class TxUtxoDto {



    Set<SpendUtxo> spendUtxoSet;
    Set<NewUtxo> newUtxoSet;
    @Data
    public static class SpendUtxo  {
        private String txId;
        private long index;
        private boolean coinbase;


        public SpendUtxo(String txId, long index) {
            this.txId = txId;
            this.index = index;
            this.coinbase=false;
        }

        public SpendUtxo(String txId, long index, boolean coinbase) {
            this.txId = txId;
            this.index = index;
            this.coinbase=coinbase;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SpendUtxo spendUtxo = (SpendUtxo) o;
            if(coinbase){
                return Objects.equal(txId, spendUtxo.txId);
            }else{
                return index == spendUtxo.index &&
                        Objects.equal(txId, spendUtxo.txId);
            }

        }

        @Override
        public int hashCode() {
            return Objects.hashCode(txId, index);
        }
    }

    @Data
    public static class NewUtxo {

        public NewUtxo(Long value, String txId, long index, String address) {
            this.value = value;
            this.txId = txId;
            this.index = index;
            this.pubKeyHash = address;
            this.scriptType=ScriptType.P2PKH;
        }

        public NewUtxo(Long value, ScriptType scriptType, String txId, long index, boolean coinbase, String address) {
            this.value = value;
            this.scriptType = scriptType;
            this.txId = txId;
            this.index = index;
            this.pubKeyHash = address;
        }

        private Long value;
        private ScriptType scriptType;
        private String txId;
        private long index;
        private String pubKeyHash;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NewUtxo newUtxo = (NewUtxo) o;
            return index == newUtxo.index &&
                    Objects.equal(txId, newUtxo.txId);

        }

        @Override
        public int hashCode() {
            return Objects.hashCode(txId, index);
        }
    }
}
