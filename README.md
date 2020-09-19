# PromotionEngine

The repository contains codebase for Modular Promotion Engine. 
Promotions are modular and independent of each other. To add any new promotion just need to add an implementation class IPromotion interface and need to define the desired promotion under calculatePriceWithPromotion() method. During checking out or price calculation this implementation class is needed to be chained for applying this promotion.
