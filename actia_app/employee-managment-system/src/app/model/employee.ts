export class Employee {
    id: number = 0;
    firstname: string = '';
    lastname: string = '';
    email: string = '';
    gender: Gender = Gender.MALE;
    photo: string = '';
}

export enum Gender {
    MALE = 'male',
    FEMALE = 'female',
    OTHER = 'other'
}


