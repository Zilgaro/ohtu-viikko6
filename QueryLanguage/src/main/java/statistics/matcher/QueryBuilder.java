package statistics.matcher;

public class QueryBuilder {
    private Matcher matcher;
    
    public QueryBuilder() {
        this.matcher = new And();
    }
    
    public Matcher build() {
        return matcher;
    }
    
    QueryBuilder oneOf(Matcher m1, Matcher m2) {
        this.matcher = new Or(m1,m2);
        return this;
    }
    
    QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new HasAtLeast(value, category);
        return this;
    }
    
    QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new HasFewerThan(value, category);
        return this;
    }
    
    QueryBuilder playsInt(String team) {
        this.matcher = new PlaysIn(team);
        return this;
    }
}
