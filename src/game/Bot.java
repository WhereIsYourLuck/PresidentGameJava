package game;

public class Bot extends Player{
    /**
     *  Constructeur de Bot
     * @param nom
     * @param position
     * @param posI
     *
     */
    public Bot(String nom, int position,  int posI) {
        super(nom, position,  posI);
    }

    /**
     *  Retire de la main du joueur la carte qu'il a posé
     * @param indexCarte position de la carte dans la main du joueur
     * @throws Exception
     *
     */
    @Override
    public void poserCarte(int indexCarte) throws Exception {
        if(this.hand.contains(this.getHand().get(indexCarte))){
            System.out.println(this.nom + " pose " + this.getHand().get(indexCarte).toString());
            this.hand.remove(this.getHand().get(indexCarte));
        } else { throw new Exception("Card isn't in the player hand"); } // On sait jamais c'est impossible normalement
    }

    /**
     * Ajoute la carte qu'il donne au joueur p
     * Retire la carte qu'il a donné de sa main
     * @param c Carte a donner quand on recommence une partie
     * @param p Quel joueur va recevoir nos cartes
     * @throws Exception Si la carte n'est pas dans la main du Bot
     */
    @Override
    public void donnerCarte(Card c, Player p) throws Exception {
        if(this.hand.contains(c)){
            p.hand.add(c);
            System.out.println(p.nom + " donne " + c.toString());
            this.hand.remove(c);
        } else { throw new Exception("Card isn't in the player hand"); } // On sait jamais c'est impossible normalement
    }

    /**
     * Permet au bot de choisir une carte à poser
     * @param c Carte à comparer = donc la carte du jeu
     * @return null si c'est un deux
     * @return la valeur de la carte si la carte est supérieure
     * @return -1 Si il ne peut pas poser de carte
     */
    @Override
    public int choixCarteIA(Card c) {
        for(Card a : hand){
            if(c == null){ return this.hand.indexOf(a); } //Si la carte est 2
            if(a.carteAPoseEstPlusGrandeQue(c)){ return this.hand.indexOf(a); }
        }
        return -1; //Si il peut rien poser
    }

    /**
     * Vérifie si la main du bot est vide
     * @return true Si sa main est vide
     * @return false si sa main n'est pas vide
     */
    @Override
    public boolean aFini() {
        if(this.hand.isEmpty()){ return true ; }
        else { return false ; }
    }
}
