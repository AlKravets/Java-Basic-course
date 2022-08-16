public class AsciiCharSequence implements CharSequence {
    private final byte [] sequence;
    
    AsciiCharSequence(byte [] sequence){
        this.sequence = sequence;
    }

    @Override
    public char charAt(int index){
        return (char) sequence[index];
    }

    @Override
    public int length(){
        return sequence.length;
    }

    @Override
    public AsciiCharSequence subSequence(int start, int end){
        // return new AsciiCharSequence(Arrays.copyOfRange(sequence, start, end));
        byte [] subSequence = new byte[end - start];
        for (int i=0; i < subSequence.length; ++i){
            subSequence[i] = sequence[i+start];
        }

        return new AsciiCharSequence(subSequence);

    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for (int i=0; i < length(); ++i){
            res.append(charAt(i));
        }
        return res.toString();
    }
}


// variant from comment
// public class AsciiCharSequence implements CharSequence {
//     private byte[] charSequence;

//     AsciiCharSequence(byte[] byteSequence) {
//         charSequence = byteSequence;
//     }

//     @Override
//     public int length() {
//         return charSequence.length;
//     }

//     @Override
//     public char charAt(int index) {
//         return (char) charSequence[index];
//     }

//     @Override
//     public AsciiCharSequence subSequence(int start, int end) {
//         return new AsciiCharSequence(Arrays.copyOfRange(charSequence, start, end));
//     }

//     @Override
//     public String toString() {
//         return new String(charSequence);
//     }
// }