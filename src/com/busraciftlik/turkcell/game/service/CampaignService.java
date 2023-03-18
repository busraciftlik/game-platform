package com.busraciftlik.turkcell.game.service;

import java.util.List;

import com.busraciftlik.turkcell.game.database.CampaignDatabase;
import com.busraciftlik.turkcell.game.entity.Campaign;
import com.busraciftlik.turkcell.game.service.api.BaseInterface;

public class CampaignService implements BaseInterface<Campaign> {

    @Override
    public void add(Campaign campaign) {
        CampaignDatabase.campaignList.add(campaign);
    }

    @Override
    public void update(Campaign campaign) {
        for (Campaign availablecampaign : CampaignDatabase.campaignList) {
            if(availablecampaign.getId() == campaign.getId()){
                availablecampaign.setDiscountPercentage(campaign.getDiscountPercentage());
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int index = 0; index<CampaignDatabase.campaignList.size(); index++){
            if(CampaignDatabase.campaignList.get(index).getId() == id){
                CampaignDatabase.campaignList.remove(index);
            }
        }
    }

    @Override
    public List<Campaign> getAll() {
        return CampaignDatabase.campaignList;
    }

    @Override
    public Campaign getById(int id) {
        for (int index = 0; index<CampaignDatabase.campaignList.size(); index++){
            if(CampaignDatabase.campaignList.get(index).getId() == id){
                return CampaignDatabase.campaignList.get(index);
            }
        }
        return new Campaign();
    }

    @Override
    public Campaign getByName(String name) {
        for (int index = 0; index<CampaignDatabase.campaignList.size(); index++){
            if(CampaignDatabase.campaignList.get(index).getName().toLowerCase().equals(name.toLowerCase())){
                return CampaignDatabase.campaignList.get(index);
            }
        }
        return new Campaign();
    }
    
}
