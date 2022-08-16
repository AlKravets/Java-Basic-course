public abstract class KeywordAnalyzer implements TextAnalyzer{
    protected abstract String [] getKeywords();

    protected abstract Label getLabel();

    @Override
    public Label processText(String text){
        Label res = Label.OK;
        String [] keywords = getKeywords();
        for (String spamWord : keywords){
            if (text.contains(spamWord)){
                res = getLabel();
                break;
            }
        }
        return res;
    }
}