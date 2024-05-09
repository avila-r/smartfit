export interface Location {
    id: number,
    title: string,
    content: string,
    isOpened: boolean,
    maskStatus: string,
    towelStatus: string,
    fountainStatus: string,
    lockerRoomStatus: string,
    schedules: Schedule[]
}

interface Schedule {
    weekdays: string,
    hour: string
}