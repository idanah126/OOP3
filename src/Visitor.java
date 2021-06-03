public interface Visitor {
    void visit(Player player);
    void visit(Enemy enemy);
    void visit(Empty empty);
    void visit(Wall wall);
    void visit(Tile tile);
}
