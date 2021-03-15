public enum DayOfWeek {
    MONDAY(8,17), TUESDAY(8, 17),
    WEDNESDAY(8, 17), THURSDAY(8, 17),
    FRIDAY (8, 16), SATURDAY, SUNDAY;

   private int beginDayHour;
    private int endDayHour;

    DayOfWeek(int beginDayHour, int endDayHour) {// констуктор для рабочих дней
        this.beginDayHour = beginDayHour;
        this.endDayHour = endDayHour;
    }

    DayOfWeek() {// констуктор для выходных
        this.beginDayHour = 0;
        this.endDayHour = 0;
    }

    static int getTodayWorkingHours(DayOfWeek day) {
        int result = day.endDayHour - day.beginDayHour;
        return (result > 0) ? result : 0;
    }

    static String getWorkingHours(DayOfWeek day) {
        if (getTodayWorkingHours(day) == 0) {// досрочное прекращение программы, если на выходе функции будет 0.
            return "Сегодня выходной";
        }

        int result = 0;
        for (int i = day.ordinal(); i < DayOfWeek.values().length; i++) {//определяем порядок дня в ENUM, до тех пор пока меньше списка дня цикл будет продолжаться.
            result += DayOfWeek.getTodayWorkingHours(DayOfWeek.values()[i]);// Возвращает массив котов и тут же уточняет элемент этого массива, затем функция работает с этим элементом
        }

        return "До конца недели осталось проработать " + result + " часов";
    }
}

