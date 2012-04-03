package de.paralleluniverse.Faithcaio.AuctionHouse;

import org.bukkit.inventory.ItemStack;
/**
 *
 * @author Faithcaio
 */
public class AuctionItem {

    protected Bidder bidder;
    protected ItemStack item;
    protected long date;
    protected String owner;
    protected Double price;
    
    public AuctionItem (Auction auction)
    {
        if (auction.bids.isEmpty())
        {
            this.bidder = auction.owner;
            this.price = 0.0;
        } 
        else
        {
          this.bidder = auction.bids.peek().getBidder();
          this.price = auction.bids.peek().getAmount();
        }
        this.item= auction.item.clone();// = new ItemStack(auction.item.getType(),auction.item.getAmount());
        this.date = System.currentTimeMillis();
        if (auction.owner instanceof ServerBidder)
           this.owner = "Server";
        else
            this.owner = auction.owner.getName();
        AuctionHouse.debug("ItemContainer Filled with: "+this.item.toString());
    }
    
    public AuctionItem (ItemStack item, Bidder bidder)
    {
        this.bidder = bidder;
        this.item = item;
        this.date = System.currentTimeMillis();
        this.owner = bidder.getName();
        this.price = 0.0;
    }
}