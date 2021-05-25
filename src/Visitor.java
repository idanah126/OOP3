public interface Visitor {
    public boolean visit(Player p);
    public boolean visit(Trap t);
    public boolean visit(Monster m);
}
