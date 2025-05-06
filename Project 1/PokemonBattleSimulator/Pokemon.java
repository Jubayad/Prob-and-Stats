public class Pokemon {
    
        private int hp;
        private int attack;
        private int defense;
        private int spAttack;
        private int spDefense;
        private int speed;

        public int getHp(){
            return hp;
        }

        public int getAttack(){
            return attack;
        }
        public int getDefense(){
            return defense;
        }

        public int getSpAttack(){
            return spAttack;
        }

        public int getSpDefense(){
            return spDefense;
        }

        public int getSpeed(){
            return speed;
        }

        public void setHp(int userHp){
            hp = userHp;
        }

        public void setattack(int userAttack){
            attack = userAttack;
        }

        public void setDefense(int userDefense){
            defense = userDefense;
        }

        public void setSpAttack(int userSpAttack){
            attack = userSpAttack;
        }

        public void setSpDefense(int userSpDefense){
            spDefense = userSpDefense;
        }

        public void setSpeed(int userSpeed){
            speed = userSpeed;
        }
    }