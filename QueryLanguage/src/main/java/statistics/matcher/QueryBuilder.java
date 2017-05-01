package statistics.matcher;

public class QueryBuilder {
    private Matcher matcher;
    
    public QueryBuilder() {
        this.matcher = new Base();
    }
    
    public Matcher build() {
        Matcher newMatcher = matcher;
        matcher = new Base();
        return newMatcher;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new And(matcher, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new And(matcher, new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }
}
